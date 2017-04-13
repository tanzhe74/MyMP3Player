package com.play;

public interface ComObserver {
		public void updateComponent(Object o);
		public void updateJPBar(Object o);
		public void updateStopStartState();
		public void updateCanSetState();
		public void updateDisableSetState();
}
