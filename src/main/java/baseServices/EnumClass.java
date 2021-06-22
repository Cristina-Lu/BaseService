package baseServices;

public class EnumClass {
    public enum pizza{
        Great,
        Start,
        Prefects,
        MyPizzaType
    }

    public pizza getMyPizza() {
        return myPizza;
    }

    public void setMyPizza(pizza myPizza) {
        this.myPizza = myPizza;
    }

    private pizza myPizza;
    public String enumWithSwitch(){
        switch (this.myPizza){
            case Great:
                return "great";
            case Start:
                return "start";
            case Prefects:
                return "prefects";
            case MyPizzaType:
                return "myPizzaType";
            default:
                return "other type";
        }
    }

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public String  replaceType() {
                return "ordered";
            }
        },
        READY (2){
            @Override
            public String replaceType() {
                return "ready";
            }
        },
        DELIVERED (0){
            @Override
            public String replaceType() {
                return "delivered";
            }
        };

        private int timeToDelivery;

        public String replaceType(){return "noType";}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public String isDeliverable() {
        return this.status.replaceType();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

// Methods that set and get the status variable.
}
