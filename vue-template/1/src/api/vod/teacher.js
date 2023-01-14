import request from '@/utils/request'


const api_name='/admin/vod/teacher'
export default {
  pageList(current,limit,searchObj){
    return request({
      //可以直接进行拼接
      url: `${api_name}/select/${current}/${limit}`,
      method: 'post',
      //使用json格式 data:searchObj
      //使用普通格式  parms:searchObj
      data:searchObj
    })
  },
  removeTeacher(id){
    return request({
      url:`${api_name}/delete/${id}`,
      method:'delete'
    })
  },
  removeTeachers(ids){
    return request({
      url:`${api_name}/delete`,
      method:'delete',
      data:ids
    })
  },
  getTeacher(id){
    return request({
      url:`${api_name}/get/${id}`,
      method:'get',
    })
  },
  saveTeacher(teacher){
    return request({
      url:`${api_name}/add`,
      method:'post',
      data:teacher
    })
  },
  updateTeacher(teacher){
    return request({
      url:`${api_name}/update`,
      method:'post',
      data:teacher
    })
  }
}

