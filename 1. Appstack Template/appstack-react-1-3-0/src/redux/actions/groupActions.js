import * as types from "../constants";
import GroupApi from '../../api/GroupApi';

const listGroupAction = (groups) => {
  return {
    type: types.GET_LIST_GROUP,
    payload: groups
  };
}

export const getListGroupAction = () => {
  return async dispatch => {
    try {
      const json = await GroupApi.getAll();
      const groups = json.content;
      console.log(groups)
      console.log(dispatch(listGroupAction(groups)));
    } catch (error) {
      console.log(error);
    }
  }
}