package taskManagerSpring.taskManagerSpring.service;

import org.springframework.stereotype.Service;
import taskManagerSpring.taskManagerSpring.model.Block;
import taskManagerSpring.taskManagerSpring.repository.BlockRepository;

import java.util.List;

@Service
public class BlockService {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public Block findById(Long id) {
        return blockRepository.getOne(id);
    }

    public List<Block> findAll() {
        return blockRepository.findAll();

    }

    public void saveBlock(Block block) {
        blockRepository.save(block);
    }


    public void deleteById(Long id) {
        blockRepository.deleteById(id);
    }
}
