import java.lang.Object;
import java.util.Iterator;

public class Array <T> implements Iterable<T> {
    private T [] data_;
    private int size_;
    private int capacity_;

    // TODO Data ownership w.r.t modification.
    private class ArrayIterator <T> implements Iterator<T> {
        private T [] iterator_data_;
        private int iteration_index_;

        public ArrayIterator(T [] data, int size) {
            // Builds an array of all the non-null entries within the dynamic 
            // array.
            int index = 0;
            this.iterator_data_ = (T [])(new Object[size]);
            for (T element : data) {
                if (element != null) {
                    // TODO Templated instantiation.
                    this.iterator_data_[index] = element;
                    index++;
                } 
            }

            this.iteration_index_ = 0;
        }

        public T next() {
            return iterator_data_[iteration_index_];
        }
        
        public boolean hasNext() {
            iteration_index_++;
            return iteration_index_ < iterator_data_.length;
        }

        public void delete() {
            throw new java.lang.UnsupportedOperationException(
                "Deletion within the iterator is not allowed."
            );
        }
    }

    public Array() {
        this.size_ = 0;
        this.capacity_ = 1;
        changeCapacity(0, this.capacity_);
    }

    public Array(int capacity) {
        // TODO Determine max upper bound supported.
        if (capacity < 0) {
            throw new java.lang.IllegalArgumentException(
                "Invalid capacity.");
        }

        this.size_ = 0;
        this.capacity_ = capacity;
        changeCapacity(0, this.capacity_);
    }

    public int size() {
        return this.size_;
    }

    public int capacity() {
        return this.capacity_;
    }

    public T at(int index) {
        if (index < 0 || this.size_ == 0 || index > this.size_) {
            throw new java.lang.IllegalArgumentException(
                "Index out of bounds error."
            );
        }
        return data_[index];
    }

    private void changeCapacity(int old_capacity, int new_capacity) {
        // TODO Is there a better way for this.
        T [] data = (T [])(new Object [new_capacity]);

        if (old_capacity == 0) {
            // just perform an allocation.
        } else if (old_capacity < new_capacity) {
            // Increase in size, copy over all the old contents over.
            for (int index = 0; index < this.size_; index++) {
                data[index] = this.data_[index];    
            }
        } else {
            // Decrease in size.
            // TODO Accounting that null could be a valid piece of data.
            int offset = 0;
            for (int index = 0; index < this.capacity_; index++) {
                if (this.data_[index] != null) {
                    data[index - offset] = this.data_[index];
                    offset++;
                }  
            }
        }

        // Update the reference for managing the array of data.
        this.data_ = data;
        this.capacity_ = new_capacity;
    }

    public void insert(T data) {
        // Default insertion at the back of the array.
        insert(data, this.size_); 
    }

    // TODO Data ownership.
    public void insert(T data, int index) {
        // TODO Handling of locations greater than size but within valid capacity.
        // Input validation
        if (index < 0 || index > this.size_) {
            throw new java.lang.IllegalArgumentException(
                "Index specified is outside valid container size."
            );
        }

        if (data == null) {
            throw new java.lang.IllegalArgumentException(
                "Not supporting null data entries within the model."
            );
        }

        if (this.size_ == this.capacity_) {
            // TODO Manage possible overflow of change in array capacity.
            changeCapacity(this.capacity_, this.capacity_ << 1);
        }

        if (index == this.size_) {
            // Placement at the back.
            this.size_++;
        }

        // Actual placement/replacement of the data at the specified index.
        this.data_[index] = data;
    }

    // TODO Handling of null entries within the array.
    // TODO Data ownership / cleanup.
    public T remove(int index) {
        T data = null;

        if (index >= this.capacity_ || index < 0) {
            throw new java.lang.IllegalArgumentException(
                "Index is not within the array capacity."
            );
        }
        
        if (this.data_[index] != null) {
            data = this.data_[index];
            this.size_--;
            this.data_[index] = null;            
        }

        // Update the capacity if necessary.
        if (this.size_ > 0 && this.size_ < (this.capacity_ / 4)) {
            // TODO Underflow protection.
            changeCapacity(this.capacity_, this.capacity_ >> 1);
        } 

        return data;
    }

    public Iterator<T> iterator() {
        return null;
    }
}