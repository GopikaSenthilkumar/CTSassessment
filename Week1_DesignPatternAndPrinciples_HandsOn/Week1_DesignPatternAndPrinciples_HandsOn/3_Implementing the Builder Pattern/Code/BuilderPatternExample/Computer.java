
public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphics;
    private String os;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphics = builder.graphics;
        this.os = builder.os;
    }

    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphics;
        private String os;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphics(String graphics) {
            this.graphics = graphics;
            return this;
        }

        public ComputerBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void showDetails() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics: " + (graphics != null ? graphics : "None"));
        System.out.println("OS: " + (os != null ? os : "No OS Installed"));
        System.out.println("--------------");
    }
}
