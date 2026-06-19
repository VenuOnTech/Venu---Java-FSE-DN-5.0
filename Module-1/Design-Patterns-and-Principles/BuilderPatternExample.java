public class BuilderPatternExample {
    static c]ass Computer {
        private String CPU;
        private String RAM;
        private String storage;

        private Computer(ComputerBuilder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
        }

        public void displaySpecs() {
            System.out.println("Computer Specifications:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
        }
    }
}
