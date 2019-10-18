public class ArrayList<T> implements List<T>
{   T[] a;
    int size = 0;

    public ArrayList()
    {
        this.a = (T[]) new Object[10];
    }
    public void add(T item)
    {
        if(size==a.length)
        {
            growArray();
        }
        a[size++]=item;
    }
    public void add(int pos, T item)
    {
        if (pos < 0 || pos > size) {
            return;
        }
        if (size == a.length) {
            growArray();
        }
        for (int i = size; i > pos; i--) {
            a[i] = a[i - 1];
        }

        size++;
        a[pos] = item;

    }

    public T get(int pos)
    {
        if(pos<0 || pos>=size)
        {
            return null;
        }
        return a[pos];
    }
    public T remove(int pos)
    {
        if(pos<0 || pos>size)
        {
            return null;
        }
        T item = a[pos];
        for(int i=pos; i<size-1; ++i) //is this right??
        {
            a[pos] = a[pos+1];
        }
        size--;
       return item;
    }
    public int size()
    {
        return size;
    }
    public void growArray()
    {
        T[] newArray = (T[]) new Object[a.length*2];
        for (int i = 0; i<a.length; i++)
        {
            newArray[i] = a[i];
        }
        a= newArray;
    }
}