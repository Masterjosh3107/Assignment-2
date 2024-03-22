all:
	javac -d bin src/GenericsKbAVLApp.java src/GUI.java src/AVLTree.java src/BinaryTree.java src/BinaryTreeNode.java src/Entry.java

doc:
	javadoc -d javadoc src/GenericsKbAVLApp.java src/GUI.java src/AVLTree.java src/BinaryTree.java src/BinaryTreeNode.java src/Entry.java -sourcepath /javadoc

clean:
	rm -f bin/*.class
	rm -rf javadoc/*

.PHONY: run
run: output.txt
	@echo "Running Java Program"
	@java -cp bin GenericsKbAVLApp > output.txt 2>&1
	@$(MAKE) output.txt > log.txt 2>&1
