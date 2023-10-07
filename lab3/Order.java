package lab3;

public class Order {
    private OrderItem[] items;
    public Order(OrderItem[] items){
        this.items = items;
    }
    public double cost(){
        double total = 0;
        
        for(int i = 0; i < items.length;i++){
            total += items[i].getP().getPrice() * items[i].getQuality();
        }
        return total;
    }
    public boolean contains(Product p){
        for(int i = 0; i < items.length;i++){
            if(items[i].getP().getId().equals(p.getId())){
                return true;
            }
        }
        return false;
    }
    public Product[] filter(String type){
        int count = 0;
        for(int i = 0; i < items.length;i++){
            if(items[i].getP().getType().equals(type)){
                count++;
            }
        }
        Product[] result = new Product[count];
        int index = 0;
        for(int i = 0 ; i < items.length; i ++){
            if(items[i].getP().getType().equals(type)){
                result[index]= items[i].getP();
                index++;
                
            }
        }
        return result;
    }

}
