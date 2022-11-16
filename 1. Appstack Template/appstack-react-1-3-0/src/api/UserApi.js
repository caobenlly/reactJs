import Api from './Api';

const url = "/users";

const existsByEmail = (email) => {
    return Api.get(`${url}/email/${email}`);
};

const existsByUsername = (username) => {
    return Api.get(`${url}/username/${username}`);
};

const create = (username, email, password, first_name, last_name) => {
    const body = {
        username: username,
        email: email,
        password: password,
        firstname: first_name,
        lastname: last_name
    }
    return Api.post(url, body);
};

const resendEmailToActiveAccount = (email) => {
    const requestParams = {
        email: email
    }

    return Api.get(`${url}/userRegistrationConfirmRequest`, { params: requestParams });
};

// export
const api = { existsByEmail, existsByUsername, create, resendEmailToActiveAccount }
export default api;