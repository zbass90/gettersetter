package gs.goott.content;

import java.util.List;

public interface ContentInterface {
	public int contentWrite(ContentVO vo); //������ ����
	public List<ContentVO> getContentList(String userid); //������ ���
	public ContentVO getContent(String userid, int contentNo); //������ 1�� ���
	public List<ContentVO> getInterestList(String userid, String interest, int contentNo); //������ ��� ����Ʈ ���
	public void viewCount(int contentNo); //��ȸ�� UP!
}
