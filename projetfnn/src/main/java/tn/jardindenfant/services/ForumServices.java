package tn.jardindenfant.services;

import java.util.List;

import tn.jardindenfant.entities.Forum;

public interface ForumServices {
	Forum AjouterForum(Forum f);
			Forum updateForum(Forum f);
			public int ajouterSujetForum(int forum_id, int sujet_id);
			void deleteForum(Forum f);
			void deleteForumById(Integer id);
			Forum getForum(Integer id);
			List<Forum> getAllForum();
			List<Forum> findBynomforum(String type_forum);
	
}
