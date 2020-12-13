package devinc.pre.mod08.original;

public class TextImpl implements IText {
	private String contents;
	private String title;
	private String author;

	public TextImpl() {
	}

	@Override
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Text [title=" + title + ", author=" + author + ", contents=" + contents + "]";
	}

	@Override
	public String getContents() {
		return contents;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

}
