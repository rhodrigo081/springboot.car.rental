package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.service.BranchService;

import java.util.List;


@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/save")
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch) {

        branchService.saveBranch(branch);

        return ResponseEntity.ok().body(branch);
    }

    @GetMapping("/search/{nameBranch}")
    public ResponseEntity<List<Branch>> searchBranch(@PathVariable String nameBranch) {
        List<Branch> branches = branchService.findByNameBranch(nameBranch);

        if (branches.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(branches);
    }

    @GetMapping("/branches-list")
    public ResponseEntity<List<Branch>> findAllBranches() {
        List<Branch> branches = branchService.findAllBranches();

        return ResponseEntity.ok().body(branches);
    }

    @DeleteMapping("/delete/{idBranch}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long idBranch) {

        Branch deleteBranch = branchService.deleteBranch(idBranch);

        if (deleteBranch == null) {
            return ResponseEntity.notFound().build();
        }

        List<Branch> branches = branchService.findAllBranches();

        return ResponseEntity.noContent().build();
    }

}
