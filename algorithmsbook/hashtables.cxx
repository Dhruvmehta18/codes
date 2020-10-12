#include <iostream>
#include <list>

using namespace std;

class HashTable
{
public:
    int BUCKET_NUM;

    list<int> *table;

    HashTable(int V);

    virtual int hashFunction(int x) = 0;

    virtual void insertItem(int x) = 0;

    virtual void deleteItem(int x) = 0;

    virtual int searchItem(int x) = 0;

    virtual void display() = 0;
};

HashTable::HashTable(int bucketNum)
{
    this->BUCKET_NUM = bucketNum;
    table = new list<int>[BUCKET_NUM];
}

class SimpleHashTable : public HashTable
{
public:
    SimpleHashTable(int V) : HashTable(V)
    {
        cout << "SimpleHashTable called" << endl;
    }

    int hashFunction(int x)
    {
        return x % BUCKET_NUM;
    }

    void insertItem(int x)
    {
        cout << "inserting value in  Table -> " << x << endl;
        int hash_value = hashFunction(x);
        table[hash_value].clear();
        table[hash_value].push_front(x);
    }

    void deleteItem(int x)
    {
        cout << "deleting item -> " << x << endl;
        int hash_value = hashFunction(x);
        table[hash_value].clear();
    }

    int searchItem(int x)
    {
        cout << "Searching Item -> " << x << endl;

        int hash_value = hashFunction(x);
        const int i = 0;
        auto &c = table[hash_value].front();
        if (c == x)
        {
            return i;
        }
        return -1;
    }

    void display()
    {
        cout << "Displaying Table" << endl;
        for (int i = 0; i < BUCKET_NUM; i++)
        {
            cout << i;
            auto &c = table[i].front();
            cout << "-->" << c;
            cout << endl;
        }
    }
};

class DivisionHashTable : public HashTable
{
public:
    DivisionHashTable(int V) : HashTable(V)
    {
        cout << "SimpleHashTable called" << endl;
    }

    int hashFunction(int x)
    {
        return x % BUCKET_NUM;
    }

    void insertItem(int x)
    {
        cout << "inserting value in  Table -> " << x << endl;
        int hash_value = hashFunction(x);

        table[hash_value].push_front(x);
    }

    void deleteItem(int x)
    {
        cout << "deleting item -> " << x << endl;

        int hash_value = hashFunction(x);

        list<int>::iterator i;
        for (i = table[hash_value].begin(); i != table[hash_value].end(); i++)
        {
            if (*i == x)
            {
                break;
            }
        }
        if (i != table[hash_value].end())
        {
            table[hash_value].erase(i);
        }
    }

    int searchItem(int x)
    {
        cout << "Searching Item -> " << x << endl;

        int hash_value = hashFunction(x);
        int i = 0;
        for (auto &&c : table[hash_value])
        {
            if (c == x)
            {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    void display()
    {
        cout << "Displaying Table" << endl;
        for (int i = 0; i < BUCKET_NUM; i++)
        {
            cout << i;
            for (auto &&c : table[i])
            {
                cout << "-->" << c;
            }
            cout << endl;
        }
    }
};

class HashTableFactory
{
public:
    enum class HashType
    {
        SIMPLE,
        MULTIPLY,
        DIVISION,
        LINEAR,
        QUADRATIC,
        DOUBLE_HASHING
    };

    static HashTable *createHashTable(HashType hashType, int bucketLimit)
    {
        switch (hashType)
        {
        case HashType::MULTIPLY:

            break;
        case HashType::DIVISION:
            return new DivisionHashTable(bucketLimit);
        case HashType::LINEAR:

            break;
        case HashType::QUADRATIC:

            break;
        case HashType::DOUBLE_HASHING:

            break;

        default:
            return new SimpleHashTable(bucketLimit);
        }
        return new SimpleHashTable(bucketLimit);
    }
};

int main(int argc, char const *argv[])
{
    HashTableFactory::HashType hashType = HashTableFactory::HashType::SIMPLE;
    int bucket_num;
    cout<<"Type the bucket value you want to use"<<endl;
    cin>>bucket_num;
    auto hashTable = HashTableFactory::createHashTable(hashType, bucket_num);
    int arr[] = {4, 1, 8, 100, 43, 12, 10};
    cout<<sizeof(arr[0])<<endl;
    int n = sizeof(arr) / sizeof(arr[0]);
    for (int i = 0; i < n; i++)
    {
        hashTable->insertItem(arr[i]);
    }
    hashTable->display();
    hashTable->deleteItem(1);
    int index = hashTable->searchItem(100);
    cout << "index of search part is -> " << index << endl;
    hashTable->display();
    return 0;
}
