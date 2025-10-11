package lessons.lesson03.part2;

import java.util.List;

public class OnlineStore {
    private List<Product> products;

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Product is added!");
    }

    public void buyProduct(String code, int quantity){
        for(Product product : products){
            if(product.getCode().equals(code)){
               if (product.getCount() <= quantity){
                   products.remove(product);
                   System.out.println("Product is fully bought!");
               } else {
                   int leftCount = product.getCount() - quantity;
                   product.setCount(leftCount);
                   System.out.printf("Product is bought! %d left", leftCount);
               }
            }
        }
    }

    public List<Product> getProducts(){
        return products;
    }
}
