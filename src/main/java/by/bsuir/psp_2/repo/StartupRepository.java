package by.bsuir.psp_2.repo;

import by.bsuir.psp_2.model.Startup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface StartupRepository extends CrudRepository<Startup, UUID> {
}
