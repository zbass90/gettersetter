package gs.goott.intro;

import java.util.List;

public interface ReplyInterface {
	//����ۼ�
	public int writeReply(String commenter,String commentContent,Double star,int introNo);
	//��� ����
	public List<replyVO> getReply(int introNo);

}
