class Item {
    public int value;
    public int indexInMap;

    public Item(int value, int indexInMap) {
        this.value = value;
        this.indexInMap = indexInMap;
    }
}

class RandomizedCollection {
    private Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private Random rand = new Random();

    public boolean insert(int value) {
        valueToIndices.putIfAbsent(value, new ArrayList<>());
        valueToIndices.get(value).add(items.size());
        items.add(new Item(value, valueToIndices.get(value).size() - 1));
        return valueToIndices.get(value).size() == 1;
    }

    public boolean remove(int value) {
        if (!valueToIndices.containsKey(value))
            return false;

        int index = lastIndex(valueToIndices.get(value));
        valueToIndices.get(last(items).value).set(last(items).indexInMap, index);
        int indicesSize = valueToIndices.get(value).size();
        valueToIndices.get(value).remove(indicesSize - 1);
        if (valueToIndices.get(value).isEmpty())
            valueToIndices.remove(value);
        items.set(index, last(items));
        items.remove(items.size() - 1);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(items.size());
        return items.get(index).value;
    }

    private int lastIndex(List<Integer> indices) {
        return indices.get(indices.size() - 1);
    }

    private Item last(List<Item> items) {
        return items.get(items.size() - 1);
    }
}