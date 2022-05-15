package tn.jardindenfant.services;
import tn.jardindenfant.services.*;
import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.*;

import java.util.List;


public interface ILikeService {
	
	public void AddLike(LikePosts likes, int user_id,int pub_id);
	public List<LikePosts> GetLikes();
	public void AddDislike(LikePosts likes, int user_id,int pub_id);
	public void Deletelike(int user_id,int pub_id);
	public void DeleteDislike(int user_id,int com_id);
	
	

}
