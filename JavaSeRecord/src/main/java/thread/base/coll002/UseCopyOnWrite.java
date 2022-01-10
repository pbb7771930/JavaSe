package thread.base.coll002;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
		@SuppressWarnings("unused")
		CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();
		
		
	}
}
