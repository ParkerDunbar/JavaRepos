package shoppinglist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shoppinglist.model.Item;
import shoppinglist.model.ShoppingList;
import shoppinglist.model.repositories.ItemJpaRepository;
import shoppinglist.model.repositories.SLJpaRepository;

@RestController
@RequestMapping("/lists")
public class SLRestController {

	/*
	 * lists/listid/item/itemid
	 */
	@Autowired
	private SLJpaRepository slrepo;
	private ItemJpaRepository itrepo;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public Integer createList(@RequestBody ShoppingList list) {
		slrepo.saveAndFlush(list);
		return list.getId();
	}
	
	@RequestMapping(path = "/{listId}", method = RequestMethod.GET)
	public ShoppingList getList(@PathVariable Integer listId) {
		return slrepo.findOne(listId);
	}
	
	@RequestMapping(path = "/{listId}", method = RequestMethod.PUT)
	public void updateList(@PathVariable Integer listId, @RequestBody ShoppingList updates) {

		ShoppingList existing = slrepo.findOne(listId);
		existing.setName(updates.getName());
		slrepo.saveAndFlush(existing);
	}

	@RequestMapping(path = "/{listId}", method = RequestMethod.DELETE)
	public void deleteList(@PathVariable Integer listId) {
		slrepo.delete(listId);
	}
	
	///////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/item", method = RequestMethod.POST)
	public void createAnItem(@PathVariable Integer listId, @RequestBody Item item) {
		itrepo.saveAndFlush(item);
	}
	
	@RequestMapping(path = "/{listId}/item", method = RequestMethod.POST)
	public void createItem(@PathVariable Integer listId, @RequestBody Item item) {
		itrepo.saveAndFlush(item);
	}
	
	@RequestMapping(path = "/{listId}/item/{itemName}", method = RequestMethod.GET)
	public Item getItem(@PathVariable Integer listId, @PathVariable String itemName) {
		return null;
	}
	
//	@RequestMapping(path = "/{listId}/item/{itemId}", method = RequestMethod.PUT)
//	public void updateItem(@PathVariable Integer listId, @PathVariable Integer itemId, @RequestBody Item updates) {
//		List<Item> existing = slrepo.findOne(listId).getItems();
//		Item exItem = existing.get(itemId);
//		exItem.setName(updates.getName());
//		exItem.setDesc(updates.getDesc());
//		exItem.setQty(updates.getQty());
//		exItem.setPrice(updates.getPrice());
//		slrepo.findOne(listId).setItems(existing);
//		slrepo.saveAndFlush(slrepo.findOne(listId));
//	}
	
	@RequestMapping(path = "/{listId}/item/{itemName}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer listId, @PathVariable String itemName) {
		slrepo.delete(listId);
	}
	

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<ShoppingList> getLists() {
		return slrepo.findAll();
	}
	
	
}
