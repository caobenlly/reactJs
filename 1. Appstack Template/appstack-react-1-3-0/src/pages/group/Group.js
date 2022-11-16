import React, { useEffect } from "react";
import {
  Card,
  CardBody,
  Col,
  Container,
  Row
} from "reactstrap";
import { getListGroupAction } from '../../redux/actions/groupActions';
import { connect } from "react-redux";
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from 'react-bootstrap-table2-paginator';
import { selectListGroup } from '../../redux/selectors/groupSelector';

const Group = (props) => {
  const getListGroups = props.getListGroupAction;

  useEffect(async () => {
    await getListGroups();
  }, [getListGroups]);

  const tableColumns = [
    {
      dataField: "name",
      text: "Name",
      sort: true
    },
    {
      dataField: "totalMember",
      text: "Total Member",
      sort: true
    }
  ];

  return (
    // <Container fluid className="p-0">
    //   <h1 className="h3 mb-3">Group Management</h1>
    //
    //   <Row>
    //     <Col>
    //       <Card>
    //         <CardBody>
    //           <BootstrapTable
    //             keyField="name"
    //             data={props.groups}
    //             columns={tableColumns}
    //             bootstrap4
	// 			striped
    //             hover
    //             bordered
    //             pagination={paginationFactory({
    //               sizePerPage: 10,
    //
    //               nextPageText: '>',
    //               prePageText: '<',
    //               withFirstAndLast: false,
    //               alwaysShowAllBtns: true,
    //
    //               hideSizePerPage: true,
    //             })}
    //           />
    //         </CardBody>
    //       </Card>
    //     </Col>
    //   </Row>
    // </Container>
      <></>
  )
};

const mapGlobalStateToProps = state => {
    console.log(state)
  return {
    groups: selectListGroup(state)
  };
};

export default connect(mapGlobalStateToProps, { getListGroupAction })(Group);