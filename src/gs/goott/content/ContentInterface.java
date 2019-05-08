package gs.goott.content;

import java.util.List;

public interface ContentInterface {
	public int contentWrite(ContentVO vo); //ÄÁÅÙÃ÷ »ı¼º
	public List<ContentVO> getContentList(String userid); //ÄÁÅÙÃ÷ ¸ñ·Ï
	public ContentVO getContent(String userid, int contentNo); //ÄÁÅÙÃ÷ 1°³ Ãâ·Â
	public List<ContentVO> getInterestList(String userid, String interest, int contentNo); //ÄÁÅÙÃ÷ ¸ñ·Ï ¸®½ºÆ® Ãâ·Â
	public void viewCount(int contentNo); //Á¶È¸¼ö UP!
}
