import javax.persistence.*;

@Entity
@Table(name = "m_item")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_number")
    private Long itemNumber;

    // getter, setter
}