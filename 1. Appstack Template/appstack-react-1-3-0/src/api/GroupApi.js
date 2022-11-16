import Api from './Api';

const url = "/groups";

const getAll = () => {
    return Api.get(url);
};

// export
const api = { getAll }
export default api;