public class FactoryMethodPatternExample {

    // Product Interface
    interface Document {
        void createDocument();
    }

    // Concrete Products
    static class WordDocument implements Document {
        @Override
        public void createDocument() {
            System.out.println("Creating a Word Document.");
        }
    }

    static class PdfDocument implements Document {
        @Override
        public void createDocument() {
            System.out.println("Creating a PDF Document.");
        }
    }

    static class ExcelDocument implements Document {
        @Override
        public void createDocument() {
            System.out.println("Creating an Excel Document.");
        }
    }

    // Abstract Factory
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete Factories
    static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Test Class
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.createDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.createDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.createDocument();
    }
}