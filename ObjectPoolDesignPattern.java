import java.util.HashMap;
import java.util.Map;

interface PoolObjectInterface {
    String setStatus(String s);
}

class PoolObject implements PoolObjectInterface {
    String status = "";

    public String setStatus(String s) {
        return this.status = s;
    }
}

class Pool {
    public PoolObject[] array = new PoolObject[10];
    public boolean isFreeResourceAvailable = false;
    public Map<Integer, Integer> clientResource;

    Pool() {
        clientResource = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            array[i] = new PoolObject();
            array[i].setStatus("Available");
        }
        this.isFreeResourceAvailable = true;
    }

    public PoolObject acquirePoolObject(int clientId) {
        boolean resourcesFree = false;
        for (int i = 0; i < 10; i++) {
            if (array[i].status.equals("Available")) {
                resourcesFree = true;
                array[i].setStatus("Not Available");
                clientResource.put(clientId, i);
                this.isFreeResourceAvailable = resourcesFree;

                return array[i];
            }
        }
        this.isFreeResourceAvailable = resourcesFree;

        if (!isFreeResourceAvailable) {
            return null;
        }
        return null;
    }

    public void releasePoolObject(int clientId) {
        if (clientResource.containsKey(clientId)) {
            int index = clientResource.get(clientId);
            array[index].setStatus("Available");
            clientResource.remove(clientId);
        } else {
            System.out.println("Client ID " + clientId + " does not have a resource to release.");
        }
    }

    public void displayPoolStatus() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Resource " + i + ": " + array[i].status);
        }
        System.out.println("Client-Resource Map: " + clientResource);
    }
}

public class ObjectPoolDesignPattern {
    public static void main(String args[]) {
        Pool pool = new Pool();

        PoolObject obj1 = pool.acquirePoolObject(101);
        PoolObject obj2 = pool.acquirePoolObject(102);

        pool.displayPoolStatus();

        pool.releasePoolObject(101);

        pool.displayPoolStatus();

        for (int i = 103; i < 113; i++) {
            PoolObject obj = pool.acquirePoolObject(i);
            if (obj == null) {
                System.out.println("Client " + i + " could not acquire a resource.");
            }
        }

        pool.displayPoolStatus();
    }
}
