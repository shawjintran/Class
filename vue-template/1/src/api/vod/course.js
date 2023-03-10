import request from '@/utils/request'

const api_name = '/admin/vod/course'

export default {
  //课程列表
  getPageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },saveCourseInfo(courseInfo) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: courseInfo
    })
  },getCourseInfoById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  //修改课程信息
  updateCourseInfoById(courseInfo) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: courseInfo
    })
  },
  getCoursePublishById(id) {
    return request({
      url: `${api_name}/getCoursePublishVo/${id}`,
      method: 'get'
    })
 },
 //发布课程  
 publishCourseById(id) {
    return request({
      url: `${api_name}/publishCourseById/${id}`,
      method: 'put'
    })
 },
 removeById(id) {
  return request({
    url: `${api_name}/remove/${id}`,
    method: 'delete'
  })
},
}