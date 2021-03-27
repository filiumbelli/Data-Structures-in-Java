public class ArrayImpl<T extends Object> implements IArray {
    private Object[] array;
    private int len = 20;
    private int currentSize = 0;

    public ArrayImpl(int num) {
        len = num;
        array = new Object[len];

    }

    public int length() {
        return currentSize;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < currentSize; i++) {
            sb.append(array[i]);
            if (i != currentSize - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public ArrayImpl() {
        array = new Object[len];
    }

    @Override
    public boolean add(Object o) {
        try {
            array[currentSize] = o;
            currentSize++;
            if (currentSize == len) {
                len *= 2;
                Object[] tempObj = new Object[len];
                for (int i = 0; i < currentSize; i++) {
                    tempObj[i] = array[i];
                }
                array = tempObj;
            }

            return true;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(Object o) {

        try {
            int breakPoint = 0;
            for (int i = 0; i < currentSize; i++) {
                if (array[i] == o) {
                    breakPoint = i;
                    break;
                }
            }
//            1,3,6,16,17,7,8
            for (int i = breakPoint; breakPoint < currentSize; i++) {
                if(i == currentSize-1){
                    break;
                }
                array[i] = array[i+1];
            }
            currentSize--;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            for (int i = 0; i < len; i++) {
                if (array[i] == o) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public ArrayImpl clone() {
       ArrayImpl<T> tempArray = new ArrayImpl<T>();
        for(int i = 0; i<currentSize;i++){
            tempArray.add(array[i]);
        }
        return tempArray;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return currentSize>0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<currentSize;i++){
            if(o == array[i]){
                return i;
            }
        }
        return -1;
    }

}
