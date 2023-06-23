public class InstanceCounter {
    private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

     InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
        for (int i = 0; i < 5; ++i) {
            new InstanceCounter();
        }
        System.out.println("Created " + InstanceCounter.getCount() + " instances");
    }
}
