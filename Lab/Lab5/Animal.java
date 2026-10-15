package Lab.Lab5;

public class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat says Meow");
    }
}

class Cow extends Animal {
    @Override
    void sound() {
        System.out.println("Cow says Moo");
    }
}

class Duck extends Animal {
    @Override
    void sound() {
        System.out.println("Duck says Quack");
    }
}

class AnimalDemo {
    public static void main(String[] args) {
        Animal[] animals = {
            new Cat(),
            new Cow(),
            new Duck()
        };

        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
