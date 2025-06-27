
public class ComputerTest {
        public static void main(String[] args) {
                Computer basic = new Computer.ComputerBuilder()
                                .setCpu("Intel i3")
                                .setRam("4GB")
                                .setStorage("500GB HDD")
                                .build();
                Computer gaming = new Computer.ComputerBuilder()
                                .setCpu("Intel i7")
                                .setRam("16GB")
                                .setStorage("1TB SSD")
                                .setGraphics("NVIDIA GTX 1660")
                                .setOs("Windows 10")
                                .build();
                Computer linux = new Computer.ComputerBuilder()
                                .setCpu("AMD Ryzen 5")
                                .setRam("8GB")
                                .setStorage("256GB SSD")
                                .setOs("Ubuntu")
                                .build();
                System.out.println("Basic Computer:");
                basic.showDetails();
                System.out.println("Gaming Computer:");
                gaming.showDetails();
                System.out.println("Linux Machine:");
                linux.showDetails();
        }
}
