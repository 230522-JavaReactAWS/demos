//Hopefully you all remember how Java Interfaces work :)
//TS interfaces have pretty much the same behavior, but we store uninitialized objects, not abstract methods
//So this will kind of take the role of our Java model classes

//We will make a UserComponent that inherits from this Interface
export interface UserInterface {
    firstName?:string,
    lastName?:string,
    username?:string,
    email?:string
}

/*we can use "?" to make the inclusion of the value OPTIONAL when making User objects. Nullable!
why? this allows us flexibility for one. No need to make 10 different constructors to suit your needs
if you know for a fact that a piece of data will ALWAYS be there, then consider no question mark. */