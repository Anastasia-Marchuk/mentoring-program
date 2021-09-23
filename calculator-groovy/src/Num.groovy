class Num {
    int size

    Num(int size) { this.size = size }

    void setSize(def size) {
        this.size = size
    }

    Num() {}

    int getSize() {
        return size
    }

    Num plus(Num other) {
        return new Num(this.size + other.size)
    }

    Num min(Num other) {
        return new Num(this.size - other.size)
    }

    def divide(Num other) throws Exception {
        if (other.size != '0')
        return new Num(this.size / other.size)

        else
            return new Exception("Can't be divided by Zero")
    }

    Num multiply(Num other) {
        return new Num(this.size * other.size)
    }

    Num power(Num other) {
        return new Num(this.size**other.size)
    }
}