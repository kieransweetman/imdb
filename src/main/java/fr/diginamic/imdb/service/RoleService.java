package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role, Integer> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Role, Integer> getRepository() {
        return roleRepository;
    }
}