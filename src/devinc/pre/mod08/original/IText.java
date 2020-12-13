package devinc.pre.mod08.original;

import devinc.pre.mod08.MethodAnnotation;

public interface IText {
	@MethodAnnotation()
	String getContents();

	@MethodAnnotation()
	String getTitle();

	String getAuthor();

	void setAuthor(String author);

	void setTitle(String title);

	void setContents(String contents);
}
