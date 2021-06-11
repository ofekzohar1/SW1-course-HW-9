package il.ac.tau.cs.sw1.ex9.riddles.first;

public class B1 extends A1 {
    @Override
    protected boolean foo() {
        // Overriding A's foo and return the negate value of current c.foo()
        // So next c.foo() == this.foo()
        C1 c = new C1();
        return !c.foo();
    }
}
