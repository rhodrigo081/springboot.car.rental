package springboot.decola.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.decola.tech.entity.Branch;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findByNameBranch(String nameBranch);
}
