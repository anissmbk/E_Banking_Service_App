package com.example.ebankingspg.java.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.ebankingspg.java.Repository.*;
import com.example.ebankingspg.java.request.UpdateClientRequest;
import com.example.ebankingspg.java.response.ChartResponse;
import com.example.ebankingspg.java.response.ClientResponse;
import com.example.ebankingspg.java.Repository.AgenceRepository;
import com.example.ebankingspg.java.Repository.ClientRepository;
import com.example.ebankingspg.java.Repository.CommissionRepository;
import com.example.ebankingspg.java.Repository.DeviseRepository;
import com.example.ebankingspg.java.Repository.RoleRepository;
import com.example.ebankingspg.java.response.StatistiqueResponse;
import com.example.ebankingspg.java.response.StringResponse;
import com.example.ebankingspg.java.services.GestClientService;
import com.example.ebankingspg.java.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.ebankingspg.java.model.*;

import javax.xml.ws.Response;

@CrossOrigin(origins = "*")
@RestController
public class GestClientController {

  @Autowired
  private GestClientService gestClientService;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AgenceRepository agenceRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private DeviseRepository deviseRepository;

  @Autowired
  private CommissionRepository commissionRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/manager_client/clients")
    public ResponseEntity<?> clients() throws Exception {
        Role role = roleRepository.findByRole("ROLE_CLIENT");
        Set<User> clients = role.getUsers();
        return ResponseEntity.ok(new ChartResponse(clients));
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/manager_client/getClient",method = RequestMethod.GET)
    public ResponseEntity<?> getclient(@RequestParam String id) throws Exception {
        Optional<Client> client = clientRepository.findById(Long.parseLong(id));
        client.orElseThrow(()->new Exception("User not found"));
        return ResponseEntity.ok(client.get());
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/manager_client/updateClient",method = RequestMethod.POST)
    public ResponseEntity<?> updateclient(@RequestBody UpdateClientRequest updateClientRequest) throws Exception {
        Optional<Client> client = clientRepository.findByEmail(updateClientRequest.getEmail());
        client.orElseThrow(()->new Exception("User not found"));
        Client client1 = client.get();
        client1.setFirstname(updateClientRequest.getFirstname());
        client1.setLastname(updateClientRequest.getLastname());
        client1.setAdress(updateClientRequest.getAddress());
        client1.setNumtel(updateClientRequest.getPhone());
        clientRepository.save(client1);
        return ResponseEntity.ok(new StringResponse("user updated successfully"));
    }


    @GetMapping(produces = "application/json")
    public List<GestClient> firstPage() {
        List<GestClient> gestclients = gestClientService.findAll();
        return gestclients;
    }
  @Autowired
  private RoleRepository rolerep;



  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @PostMapping
  public GestClient create(@RequestBody GestClient gestcli) {

    String pass = gestcli.getPassword();
    String newpass = bCryptPasswordEncoder.encode(pass);
    gestcli.setPassword(newpass);
    Set<Role> roles1 = new HashSet<Role>();
    roles1.add(rolerep.findByRole("ROLE_CLIENT_MANAGER"));
    gestcli.setRoles(roles1);
        gestClientService.create(gestcli);
        return gestcli;
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/manager_client/dashboard")
    public ResponseEntity<?> dashboard() throws Exception {
        long totalAgences = agenceRepository.count();
        long totalClient = clientRepository.count();
        Optional<Devise> tauxDeChange = deviseRepository.findByName("DHS");
        tauxDeChange.orElseThrow(()->new Exception("Taux de change not found"));
        Devise devise = tauxDeChange.get();
        double exchangeRate = devise.getExchangeRate();
        Commission commission = commissionRepository.findById(1);
        double transfert = (long) commission.getTransfert();
        return ResponseEntity.ok(new StatistiqueResponse(totalClient,totalAgences,exchangeRate,transfert));
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/manager_client/chart")
    public ResponseEntity<?> chart() throws Exception {
        Role role = roleRepository.findByRole("ROLE_CLIENT");
        Set<User> clients = role.getUsers();
        return ResponseEntity.ok(new ChartResponse(clients));
    }


}
