package org.example.onlineshop.Controller;

import lombok.RequiredArgsConstructor;
import org.example.onlineshop.DTO.RoleDTO;
import org.example.onlineshop.Exception.NotFound;
import org.example.onlineshop.Service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<RoleDTO> Create_Role(@RequestBody RoleDTO roleDTO) throws NotFound {
        RoleDTO result = roleService.Add_Role(roleDTO);
        return new  ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/role")
    public ResponseEntity<List<RoleDTO>> Get_All_Role() {
        List<RoleDTO> list = roleService.getAllRole();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<RoleDTO> Get_All_Role_by_name(@PathVariable String name) throws NotFound {
        return new ResponseEntity<>(roleService.getRoleByName(name),HttpStatus.OK);
    }

    @DeleteMapping("/role/{name}")
    public ResponseEntity<?> Delete_Role(@PathVariable String name) throws NotFound {
        roleService.DeleteRoleByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/role/{name}")
    public ResponseEntity<?> Update_Role(@PathVariable String name, @RequestBody RoleDTO roleDTO) throws NotFound {
        roleService.UpdateRoleByName(name,roleDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
