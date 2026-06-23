public class ProxyPatternExample {

    // Subject Interface
    interface Image {
        void display();
    }

    // Real Subject
    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image from remote server: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    // Proxy Class
    static class ProxyImage implements Image {
        private String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            // Lazy Initialization and Caching
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    // Test Class
    public static void main(String[] args) {

        Image image = new ProxyImage("sample.jpg");

        System.out.println("First Display:");
        image.display();

        System.out.println("\nSecond Display:");
        image.display();
    }
}