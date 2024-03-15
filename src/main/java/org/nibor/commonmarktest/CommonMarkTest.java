package org.nibor.commonmarktest;

import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.ext.image.attributes.ImageAttributesExtension;
import org.commonmark.ext.ins.InsExtension;
import org.commonmark.ext.task.list.items.TaskListItemsExtension;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.markdown.MarkdownRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CommonMarkTest {
    public static void main(String[] args) throws IOException {
        var extensions = List.of(
                AutolinkExtension.create(),
                StrikethroughExtension.create(),
                TablesExtension.create(),
                HeadingAnchorExtension.create(),
                ImageAttributesExtension.create(),
                InsExtension.create(),
                TaskListItemsExtension.create(),
                YamlFrontMatterExtension.create()
        );
        var parser = Parser.builder().extensions(extensions).build();
//        var renderer = MarkdownRenderer.builder().extensions(extensions).build();
        var renderer = HtmlRenderer.builder().extensions(extensions).build();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            var document = parser.parseReader(reader);
            renderer.render(document, System.out);
            System.out.flush();
        }
    }
}
