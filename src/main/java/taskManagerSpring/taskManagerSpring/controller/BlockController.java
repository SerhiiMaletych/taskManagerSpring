package taskManagerSpring.taskManagerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.model.Task;
import taskManagerSpring.taskManagerSpring.repository.BlockRepository;
import taskManagerSpring.taskManagerSpring.service.BlockService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BlockController {

    private final BlockService blockService;
    private final BlockRepository blockRepository;

    public BlockController(BlockService blockService, BlockRepository blockRepository) {
        this.blockService = blockService;
        this.blockRepository = blockRepository;
    }

    @GetMapping("/all")
    public String findAllBlocks(Model model) {
        List<Block> block = blockService.findAll();
        model.addAttribute("block", block);
        return "block/all";

    }


    @GetMapping("block-create")
    public String createForm(Block block) {
        return "block/create-page";

    }

    @PostMapping("block-create")
    public String createBlock(Block block) {
        blockService.saveBlock(block);
        return "redirect:/";
    }


    @GetMapping("/block-update/{id}")
    public String updateBlockForm(@PathVariable("id") Long id, Model model) {
        Block block = blockRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("block", block);
        return "block/update-page";
    }

    @PostMapping("/block-update/{id}")
    public String updateBlock(@PathVariable("id") long id, @Valid Block block, BindingResult result) {
        if (result.hasErrors()) {
            block.setId(id);
            return "block/update-page";
        }

        blockService.saveBlock(block);

        return "redirect:/";
    }

    @GetMapping("/block-delete/{id}")
    public String deleteBlock(@PathVariable("id") Long id) {
        Block block = blockRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        blockRepository.delete(block);
        return "redirect:/";
    }

}