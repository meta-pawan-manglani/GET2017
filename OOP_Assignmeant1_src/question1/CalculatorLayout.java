package question1;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public interface CalculatorLayout {
   void addLayoutComponent(String name, Component comp);
   Dimension LayoutSize(Container contain);
   void removalLayoutComponent();
}
