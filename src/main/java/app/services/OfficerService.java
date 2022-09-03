package app.services;

import app.models.Officer;
import app.repositories.OfficeRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OfficerService implements UserDetailsService {

    private final OfficeRepo officeRepo;

    @PersistenceContext
    private EntityManager manager;

    public OfficerService(OfficeRepo officeRepo) {
        this.officeRepo = officeRepo;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        Officer officer = officeRepo.findAllByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new Officer();
    }

}
