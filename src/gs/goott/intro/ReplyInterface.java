package gs.goott.intro;

import java.util.List;

public interface ReplyInterface {
	//¥Ò±€¿€º∫
	public int writeReply(String commenter,String commentContent,Double star,int introNo);
	//¥Ò±€ ∫∏±‚
	public List<replyVO> getReply(int introNo);

}
