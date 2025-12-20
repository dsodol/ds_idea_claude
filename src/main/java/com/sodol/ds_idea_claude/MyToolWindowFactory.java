package com.sodol.ds_idea_claude;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MyToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        MyToolWindowContent toolWindowContent = new MyToolWindowContent();
        Content content = ContentFactory.getInstance().createContent(toolWindowContent.getContentPanel(), "", false);
        toolWindow.getContentManager().addContent(content);
    }

    private static class MyToolWindowContent {
        private final JPanel contentPanel = new JPanel();

        public MyToolWindowContent() {
            contentPanel.setLayout(new BorderLayout(0, 20));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JLabel label = new JLabel("Ds Idea Claude Tool Window");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(label, BorderLayout.NORTH);

            JButton button = new JButton("Click Me");
            button.addActionListener(e -> JOptionPane.showMessageDialog(contentPanel, "Hello from the Tool Window!"));
            contentPanel.add(button, BorderLayout.CENTER);
        }

        public JPanel getContentPanel() {
            return contentPanel;
        }
    }
}
