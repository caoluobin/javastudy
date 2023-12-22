package org.clb.juc.thread.reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class CleanerT extends PhantomReference<Object> {
    public static final ReferenceQueue<Object> dummyQueue = new ReferenceQueue();
    public CleanerT(Object referent) {
        super(referent, dummyQueue);
    }
}
