import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryRepository repository;

    public InventoryController(InventoryRepository repository) {
        this.repository = repository;
    }

    // 一覧取得
    @GetMapping
    public List<Inventory> getAll() {
        return repository.findAll();
    }

    // 登録
    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return repository.save(inventory);
    }

    // 修正
    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryDetails) {
        Inventory inventory = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventory.setItemName(inventoryDetails.getItemName());
        inventory.setItemNumber(inventoryDetails.getItemNumber());
        return repository.save(inventory);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        repository.deleteById(id);
    }
}