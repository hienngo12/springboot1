    package springboot.demo_springboot.entity;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "product")
    public class ProductEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "name")
        private String name;
        @Column(name = "description")
        private String description;
        @Column(name = "unitprice")
        private Integer unitprice;

        public ProductEntity() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getUnitprice() {
            return unitprice;
        }

        public void setUnitprice(Integer unitprice) {
            this.unitprice = unitprice;
        }

        @Override
        public String toString() {
            return "ProductEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", unitPrice=" + unitprice +
                    '}';
        }
    }
