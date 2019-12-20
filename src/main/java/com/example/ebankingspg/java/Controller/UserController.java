package com.example.ebankingspg.java.Controller;

import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.model.User;
import com.example.ebankingspg.java.request.AuthenticationRequest;
import com.example.ebankingspg.java.request.ForgotPasswordRequest;
import com.example.ebankingspg.java.request.SendEmailRequest;
import com.example.ebankingspg.java.response.AuthenticationResponse;
import com.example.ebankingspg.java.response.StringResponse;
import com.example.ebankingspg.java.services.MyUserDetailsService;
import com.example.ebankingspg.java.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(produces = "application/json")
  	@RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect email or password");
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt,userDetails));
    }

    @GetMapping(produces = "application/json")
    @CrossOrigin
    @RequestMapping(value = "/check_token" , method = RequestMethod.GET)
    public ResponseEntity<?> checkToken(HttpServletRequest request) throws Exception {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            String email = jwtTokenUtil.extractUsername(jwt);
            if(email != null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
                if(jwtTokenUtil.validateToken(jwt,userDetails)){
                    return ResponseEntity.ok(new AuthenticationResponse(jwt,userDetails));
                }
            }
        }
        return ResponseEntity.badRequest().body(new StringResponse("error"));
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/home")
    public String home(){
	    return "homePage";
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/forgot_password")
    public ResponseEntity<?> forgot_password(@RequestBody ForgotPasswordRequest forgotPasswordRequest){
        Optional<User> user = userRepository.findByToken(forgotPasswordRequest.getToken());
        user.orElseThrow(()->new UsernameNotFoundException("Token not found"));
        User userDatabase = user.get();
        if(userDatabase.getToken().equals("")){
            throw  new UsernameNotFoundException("Token not found");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        userDatabase.setPassword(passwordEncoder.encode(forgotPasswordRequest.getPassword()));
        userDatabase.setToken("");
        userRepository.save(userDatabase);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(userDatabase.getEmail());
        msg.setSubject("Manager client banque");
        msg.setText("Check si vous avez fait un reset password");
        javaMailSender.send(msg);
        return ResponseEntity.ok(new StringResponse("Password updated successfully"));
    }


    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/send_email", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmailForgotPassword(@RequestBody SendEmailRequest sendEmailRequest){
	    Optional<User> user = userRepository.findByEmail(sendEmailRequest.getEmail());
        user.orElseThrow(()->new UsernameNotFoundException("email not found"));
        User userDatabase = user.get();
        userDatabase.setToken(getAlphaNumericString(20));
        SimpleMailMessage msg = new SimpleMailMessage();
        userRepository.save(userDatabase);
        msg.setTo(sendEmailRequest.getEmail());
        msg.setSubject("Manager client banque");
        msg.setText("Hey \n here is the link \n http://localhost:4200/forgot_password/" + userDatabase.getToken());
        javaMailSender.send(msg);
        return ResponseEntity.ok(new StringResponse("Email sent successfully"));
    }

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
